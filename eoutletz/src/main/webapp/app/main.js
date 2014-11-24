var debug = true;

var log = function (message) {
	if(!message) { return; }
	if(window.console && debug) { console.log(message); }
};

require.config({  
	baseUrl: 'app',  
    paths: {
        'angular': ['https://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular','components/angular/angular'],
        'angular-ui.router': ['components/angular/angular-route.min'],
        'app' : 'app',
        'routeResolver' : 'util/routeResolver'
    },
    shim: { 
    	'angular' : {'exports' : 'angular'},
    	'angular-ui.router': {deps: ['angular']}
    }
});

require(['app'], function (app) {
  app.init();
});