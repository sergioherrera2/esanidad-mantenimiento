function add($scope) {
    $scope.items = ['Edu', 'Miguel', 'Antonio', 'Juan Luis', 'Juan'];
    $scope.AddItem = function() {
        $scope.items.push($scope.newItem);
    };
    $scope.RemoveItem = function(item) {
        $scope.items.splice($scope.items.indexOf(item), 1);
    };
};