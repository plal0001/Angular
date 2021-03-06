'use strict';

/** View controller */
class ClientesCtrl {

    constructor(clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

    $onInit() {
        //Init view model
        this.editMode = false;
        this.cliente = {};
        this.clientes = [];
        this.errMsgs = [];
        //Init view
        this.updateClientes();
        this.reset();
    }

    //view actions
    crea() {
        this.reset();
        this.editMode = true;
    }
    edita(id) {
        this.reset();
        this.clientesDAO.busca(id).then(cliente => {
            this.cliente = cliente;
            this.editMode = true;
        }).catch(response => this.errorDAO(response));
    }
    borra(id) {
        if (angular.isNumber(id)) {
            this.clientesDAO.borra(id)
                    .then(() => this.updateClientes())
                    .catch(response => this.errorDAO(response));

        }
    }
    guarda(cliente) {
        if (cliente.id > 0) {
            //Modify cliente data
            this.clientesDAO.guarda(cliente)
                    .then(() => this.updateClientes())
                    .catch(response => this.errorDAO(response));
        } else {
            //New cliente
            cliente.id = 0;
            this.clientesDAO.crea(cliente)
                    .then(() => this.updateClientes())
                    .catch(response => this.errorDAO(response));
        }
    }
    //Util methods
    reset() {
        this.cliente = {};
        this.editMode = false;
        this.errMsgs = [];
    }
    updateClientes() {
        this.clientesDAO.buscaTodos()
                .then(clientes => this.clientes = clientes)
                .catch(response => this.errorDAO(response));
        this.reset();
    }
    errorDAO(response) {
        this.errMsgs = response.data; //JAX-RS BeanValidation errors
        console.log("Error en servidor: " + response.status + " " + response.statusText);
    }

} //ClientesCtrl

/** Routing View controller */
class ClientesRouteCtrl {
    constructor($routeParams, $location, clientesDAO) {
        //Dependency injection
        this.$routeParams = $routeParams;
        this.$location = $location;
        this.clientesDAO = clientesDAO;

        //Process routing request
        this.$onInit();
    }

    $onInit() {
        //Init view model 
        this.cliente = {};
        this.clientes = [];
        this.errMsgs = [];

        //Process path actions
        let idCliente = (this.$routeParams.idCliente ? parseInt(this.$routeParams.idCliente) : 0);
        let action = "";
        if (this.$location.path().length) {
            //extract action name from path
            action = this.$location.path().match(/^\/?(\w+)/)[1];
        }

        switch (action) {
            case "visualiza":
            case "edita":
                this.clientesDAO.busca(idCliente)
                        .then(cliente => this.cliente = cliente)
                        .catch(response => this.errorDAO(response));
                break;
            case "crea":
                this.cliente = {};
                break;
            case "borra":
                this.clientesDAO.borra(idCliente)
                        .then(() => this.updateClientes())
                        .catch(response => this.errorDAO(response));
                break;
            default :
                //default: action=="lista"
                this.clientesDAO.buscaTodos()
                        .then(clientes => this.clientes = clientes)
                        .catch(response => this.errorDAO(response));
        }
    }

    //edita.html view button actions
    borra(id) {
        if (angular.isNumber(id)) {
            this.clientesDAO.borra(id)
                    .then(() => this.updateClientes())
                    .catch(response => this.errorDAO(response));
        }
    }
    guarda(cliente) {
        if (cliente.id > 0) {
            //Modify cliente data
            this.clientesDAO.guarda(cliente)
                    .then(() => this.updateClientes())
                    .catch(response => this.errorDAO(response));
        } else {
            //New cliente
            cliente.id = 0;
            this.clientesDAO.crea(cliente)
                    .then(() => this.updateClientes())
                    .catch(response => this.errorDAO(response));
        }
    }
    //Util methods
    updateClientes() {
        this.$location.path("/lista");  //Post-Redirect-Get
    }

    errorDAO(response) {
        this.errMsgs = response.data; //JAX-RS BeanValidation errors
        console.log("Error en servidor: " + response.status + " " + response.statusText);
    }

} //ClientesRouteCtrl

/** Angular module for controllers */
angular.module('clientesApp.controllers', [])
        .controller('ClientesCtrl', ['ClientesDAOREST', ClientesCtrl])
        .controller('ClientesRouteCtrl', ['$routeParams', '$location', 'ClientesDAOREST', ClientesRouteCtrl]);

