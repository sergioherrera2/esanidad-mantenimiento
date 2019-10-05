function add($scope) {
    $scope.items = ['cita1', 'cita2', 'cita3'];
    $scope.AddItem = function() {
        $scope.items.push($scope.newItem);
    };
    $scope.RemoveItem = function(item) {
        $scope.items.splice($scope.items.indexOf(item), 1);
    };
};