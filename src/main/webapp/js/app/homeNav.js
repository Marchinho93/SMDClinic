angular.module("homeNav", [])
	.controller("homeNavController", function ($scope, $templateRequest, $sce, $compile, $window, $rootScope){
		var thisURL = "";
		var lastURL = "";
		var carouselToggled = false; // is carousel up?
		var carousel = null;
		var htmlContainer = null;
		if(angular.isElement(document.getElementById("myCarousel"))){
			var carousel = angular.element(myCarousel); // getting carousel (variable part)
			htmlContainer = angular.element(HTMLContainer);
			initHTML();
		}
		$scope.update = function(url){
			thisURL = url;
			click();
			$scope.urlActive = thisURL;
		}
		$scope.href = function(url){
				$rootScope.bodyClass = 'body-leaving';
				setTimeout(function(){
					htmlContainer = "";
					$rootScope.bodyClass = 'notVisible';
					$window.location.href = url;
					$scope.urlActive = url;}
				, 1000);				
		}
		function click() {
			if(carouselToggled){
				if(isAnotherElement()){
					if(thisURL=='home'){
						carousel.removeClass('carouselAnimUp');
						carousel.addClass('carouselAnimDown');
						toggleVisibility();
						carouselToggled = false;
						makeTheMagicHappen();
					}
					else{
						makeTheMagicHappen();
					}
					lastURL = thisURL;
				}
				else{
					makeTheMagicHappen();
					lastURL = thisURL;
				}
			}
			else{
				if(thisURL!='home'){
					carousel.removeClass('carouselAnimDown');
					carousel.addClass('carouselAnimUp');
					setTimeout(toggleVisibility, 1000);
					carouselToggled = true;
				}
				makeTheMagicHappen();
				lastURL = thisURL;
			}
		};
		
		function initHTML(){
			thisURL = "home";
			$scope.urlActive = thisURL;
			var templateURL = $sce.getTrustedResourceUrl('templates/home/home.html');
			$templateRequest(templateURL).then(function(template){
				$compile(htmlContainer.html(template).contents())($scope);
			},function(){
				console.log("fileerror");
			});
			console.log("initialized")
		};
		function toggleVisibility (){
			carousel.toggleClass('notVisible');
		};
		function changeHTML(){
			setTimeout(function(){
				var templateURL = $sce.getTrustedResourceUrl('templates/home/'+thisURL+'.html');
				console.log(templateURL);
				$templateRequest(templateURL).then(function(template){
					$compile(htmlContainer.html(template).contents())($scope);
				},function(){
					console.log("fileerror");
				});
			},1000);
		};
		function isAnotherElement(){
			return thisURL != lastURL;
		}
		function makeTheMagicHappen(){
			htmlContainer.addClass('opacityDown');
			setTimeout(changeHTML(), 1000);
			setTimeout(function(){
				htmlContainer.removeClass('opacityDown');
				}, 1000);
			setTimeout(function(){
				htmlContainer.addClass('opacityUp');
				}, 1000);
			setTimeout(function(){
				htmlContainer.removeClass('opacityUp');
				}, 2000);
		}
	});
/*
angular.module("adminNav", [])
.controller("adminNavController", function ($scope, $templateRequest, $sce, $compile, $window, $rootScope){
	var thisURL = "";
	var htmlContainer = angular.element(HTMLContainer);
	initHTML();
	$scope.update = function(url){
		thisURL = url;
		click();
		$scope.urlActive = thisURL;
	}
	$scope.href = function(url){
			$rootScope.bodyClass = 'body-leaving';
			setTimeout(function(){
				$rootScope.bodyClass = 'notVisible';
				$window.location.href = url;}
			, 1000);				
	}
	function click() {
				makeTheMagicHappen();
	};
	
	function initHTML(){
		thisURL = "adminHome";
		$scope.urlActive = thisURL;
		var templateURL = $sce.getTrustedResourceUrl('/templates/admin/adminHome.html');
		$templateRequest(templateURL).then(function(template){
			$compile(htmlContainer.html(template).contents())($scope);
		},function(){
			console.log("fileerror");
		});
		console.log("initialized")
	};
	function changeHTML(){
		setTimeout(function(){
			var templateURL = $sce.getTrustedResourceUrl('templates/patient/' + thisURL + '.jsp');
			$templateRequest(templateURL).then(function(template){
				$compile(htmlContainer.html(template).contents())($scope);
			},function(){
				console.log("fileerror");
			});
		},1000);
	};
	function makeTheMagicHappen(){
		htmlContainer.addClass('opacityDown');
		setTimeout(function(){changeHTML();
			htmlContainer.removeClass('opacityDown');
			}, 1000);
		setTimeout(function(){
			htmlContainer.addClass('opacityUp');
			}, 1000);
		setTimeout(function(){
			htmlContainer.removeClass('opacityUp');
			}, 2000);
	}
});*/