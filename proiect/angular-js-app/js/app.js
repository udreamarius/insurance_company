var app = angular.module('blog', [ ]);

app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
  $scope.helloWorld = 'Aplicatii Web cu suport Java!';

  $scope.cards = [];
  $scope.keysCard = [];

  $scope.card = {};
  $scope.editCard = {};

  $scope.newname = '';


  $scope.cass = [];
  $scope.keysCas = [];

  $scope.cas = {};
  $scope.editCas = {};

  $scope.address = '';


  $scope.persoanas = [];
  $scope.keysPersoana = [];

  $scope.persoana = {};
  $scope.editPersoana = {};



  $http.get('http://localhost:8080/card').then(
    function successCallback(response) {

    $scope.cards = response;
    $scope.keysCard = Object.keys(response.data[0]);
  });


  $scope.addCard = function(card) {
    $scope.cards.data.push(card);
    $http.post('http://localhost:8080/card', card);
    $scope.card = {};
  };

  $scope.setUpdateCard = function(card) {
    $scope.editCard = card;
  };


  $scope.openCard = function(card) {
    alert(card.id + " : " + card.name);
  };


  $scope.setUpdateCard = function(card) {
    $scope.editCard = card;
    console.log($scope.editCard);
  };


  $scope.updateCard = function() {
    $http.put('http://localhost:8080/card/' + $scope.editCard.id, { "newName" : $scope.newname });
    $scope.editCard.name = $scope.newname;
    $scope.editCard = {};
    $scope.newname = '';
  };

  $scope.deleteCard = function(card) {
    console.log(card);
    $http.delete('http://localhost:8080/card/' + card.id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + card.id + ']').remove();
    });
  };






  $http.get('http://localhost:8080/CAS').then(
    function successCallback(response) {

    $scope.cass = response;
    $scope.keysCas = Object.keys(response.data[0]);
  });


  $scope.addCas = function(cas) {
    $scope.cass.data.push(cas);
    $http.post('http://localhost:8080/CAS', cas);
    $scope.cas = {};
  };

  $scope.setUpdateCas = function(cas) {
    $scope.editCas = cas;
  };


  $scope.openCas = function(cas) {
    alert(cas.id + " : " + cas.name);
  };


  $scope.setUpdateCas = function(cas) {
    $scope.editCas = cas;
    console.log($scope.editCas);
  };


  $scope.updateCas = function() {
    $http.put('http://localhost:8080/CAS/' + $scope.editCas.id, { "newName" : $scope.newName, "address" : $scope.address});
    $scope.editCas.name = $scope.newName;
    $scope.editCas.address = $scope.address;
    $scope.editCas = {};
    $scope.newName = '';
    $scope.address = '';
  };

  $scope.deleteCas = function(cas) {
    console.log(cas);
    $http.delete('http://localhost:8080/CAS/' + cas.id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + cas.id + ']').remove();
    });
  };






$http.get('http://localhost:8080/persoana').then(
    function successCallback(response) {

    $scope.persoanas = response;
    $scope.keysPersoana = Object.keys(response.data[0]);
  });



  $scope.openPersoana = function(persoana) {
    alert(persoana.id + " : " + persoana.name);
  };



  $scope.deletePersoana = function(persoana) {
    console.log(persoana);
    $http.delete('http://localhost:8080/persoana/' + persoana.id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + persoana.id + ']').remove();
    });
  };

  
}]);

