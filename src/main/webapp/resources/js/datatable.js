(function() {
	$(document).bind('keyup keydown', function(e) {
		shifted = e.shiftKey;
	});
})();

var DOSW = DOSW || {};

DOSW.tabCell = function(src, dataTable) {
	var cell = $(document.getElementById(src)).parents('td');
	dataTable.tabCell(!shifted ? cell.next() : cell, !shifted);
};
