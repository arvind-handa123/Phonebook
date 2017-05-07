(function() {
    var app = angular.module('phoneBookCRUD', [ ]);

    app.controller('PhonebookController', ['$scope', '$http', function ($scope, $http) {

        var phonebook = this;
        phonebook.contacts = [];
        phonebook.newContact = {};
        
        this.getPhonebook = function() {
            $http.get('/Phonebook/contacts.json').then(function successful(response) {
                jsonData = response.data;
                phonebook.contacts = response.data;
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
                $scope.phonebook.getPhonebook();
            });
        };
        
        this.updateContact = function(contact) {
            this.populateForm(contact);
            this.deleteContact(contact.id);    
            $scope.phonebook.getPhonebook();
        };
        
        //source: http://stackoverflow.com/a/28257811
        this.startsWith = function (actual, expected) {
            var lowerStr = (actual + "").toLowerCase();
            return lowerStr.indexOf(expected.toLowerCase()) === 0;
        };

        //source: http://stackoverflow.com/a/4878800
        capitalizeFirstLetters = function(str) {
            if (str)
                return str.replace(/\w\S*/g, function(txt) {
                    return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
                });
            else
                return str;
        };

        this.addContact = function() {
            phonebook.newContact.name = capitalizeFirstLetters(phonebook.newContact.name);
      
            $http.post('/Phonebook/addContact', phonebook.newContact).then(function() {
            });
            phonebook.newContact = {};
            $scope.contactForm.$setPristine();
            $scope.contactForm.$setUntouched();
            $scope.phonebook.getPhonebook();
        };
        
        this.populateForm = function(contact) {
            contact.name = capitalizeFirstLetters(contact.name)
            phonebook.newContact.name = contact.name;
            phonebook.newContact.phoneNumber = contact.phoneNumber;

            $scope.contactForm.$setDirty();
            console.log($scope.contactForm.$valid);
        };
    }]);
})();
