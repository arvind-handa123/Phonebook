(function() {
    var app = angular.module('phoneBookCRUD', [ ]);

    app.controller('PhonebookController', ['$scope', '$http', function ($scope, $http) {

    	var phonebook = this;
        phonebook.contacts = []
    	
        this.getPhonebook = function() {
            $http.get('/Phonebook/contacts.json').then(function successful(response) {
                jsonData = response.data;
                finalData = JSON.parse(jsonData);	//the JSON needs to parsed
                
                phonebook.contacts = finalData;
                console.log(phonebook.contacts);
            });
        };
        
        this.getPhonebook();

        this.deleteAllContacts = function() {
            $http.delete('/Phonebook/deleteAllContacts').then(function() {
            	$scope.phonebook.getPhonebook();
            });
        };

        this.deleteContact = function(id) {
            $http.delete('/Phonebook/deleteContact/' + id).then(function() {
            });
            $scope.phonebook.getPhonebook();
        }
        
        //source: http://stackoverflow.com/a/28257811
        this.startsWith = function (actual, expected) {
            var lowerStr = (actual + "").toLowerCase();
            return lowerStr.indexOf(expected.toLowerCase()) === 0;
        };
    }]);

    app.controller('ContactController', ['$scope', '$http', function($scope, $http) {
        this.contact = {};

        //source: http://stackoverflow.com/a/4878800
        capitalizeFirstLetters = function(str) {
            if (str)
                return str.replace(/\w\S*/g, function(txt) {
                    return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
                });
            else
                return str;
        };

        this.addContact = function(phonebook) {
            this.contact.name = capitalizeFirstLetters(this.contact.name);
      
            $http.post('/Phonebook/addContact', this.contact).then(function() {
            });
            this.contact = {};
            $scope.contactForm.$setPristine();
            $scope.contactForm.$setUntouched();
            $scope.phonebook.getPhonebook();
        };
    }]);
})();
