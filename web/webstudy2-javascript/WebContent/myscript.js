function testSrc(){
	alert("방가방가");
}

function menuOrder() {
	var f = document.menuForm;
		var flag = false;
		for (var i = 0; i < f.menu.length; i++) {
			if (f.menu[i].checked) {
				flag=true;
				break;
			}
		}
		if (flag==false) {
			alert("메뉴를 선택하세요!");
			return false;
		}
		if (f.count.value == "") {
			alert("수량을 입력하세요");
			return false;
		}
		if (isNaN(f.count.value)) {
			alert("숫자로 입력하세요!");
			return false;
		}
		f.reset();
	}