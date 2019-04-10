var app = angular.module('enerv', [ "ngResource" ]);

app.controller('enervController', [ '$scope', '$http',
                                     
	function($scope, $http) {
		$scope.getUser = function() {
			$http.getUser('/enerv').success(function(data) {
				$scope.user = data;
			});
		}
		
		$scope.addUser = function() {
			$http.post('/enerv', 
				{
					title : $scope.title,
					year : $scope.year,
					director : $scope.director
				}
			).success(function(data) {
				$scope.msg = 'Usuario creado correctamente';
				$scope.getUser();
			}).error(function(data) {
				$scope.msg = 'Se ha producido un error';
			});
		}
} ]);