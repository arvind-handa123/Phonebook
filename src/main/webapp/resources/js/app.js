(function() {
    var app = angular.module('phoneBookCRUD', [ ]);

    app.controller('PhonebookController', ['$http', function ($http) {
        var phonebook = this;
        phonebook.contacts = [];
        $http.get('/Phonebook/contacts.json').then(function successful(response) {
            jsonData = response.data;
            finalData = JSON.parse(jsonData);	//the JSON needs to parsed
            
            phonebook.contacts = finalData;
            console.log(phonebook.contacts);
        });
        
        //source: http://stackoverflow.com/a/28257811
        this.startsWith = function (actual, expected) {
            var lowerStr = (actual + "").toLowerCase();
            return lowerStr.indexOf(expected.toLowerCase()) === 0;
        };
    }]);

    app.controller('ContactController', ['$scope', function($scope) {
        this.contact = {};


        //source: http://stackoverflow.com/a/4878800
        capitalizeFirstLetters = function(str) {
            return str.replace(/\w\S*/g, function(txt) {
                return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
            });
        }

        this.addContact = function(phonebook) {
            this.contact.name = capitalizeFirstLetters(this.contact.name);
            phonebook.contacts.push(this.contact);

            this.contact = {};
            $scope.contactForm.$setPristine();
            $scope.contactForm.$setUntouched();
        };
    }]);
})();
