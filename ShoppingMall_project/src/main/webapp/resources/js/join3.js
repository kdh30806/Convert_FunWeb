$(document).ready(function(){
	
	$('#idSpan').html("아이디를 입력해 주세요. (영문소문자/숫자, 4~16자)");
	$('#passSpan').html("영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~16자을 입력해야 합니다.");	

	$('#id').keyup(function(){
		var id= document.getElementById('id').value;
		var checkCha= id.search(/[!@#$%^&*()]/g);	
		var checkUpper = id.search(/[A-Z]/g);
		
		if(!(checkCha == -1)){
			$('#idSpan').html("특수 문자는 사용할 수 없습니다.");
			return false;
		}
		if(!(checkUpper == -1)){
			$('#idSpan').html("영문 대문자는 사용할 수 없습니다.");
			return false;
		}
		if(!/^[a-z0-9]{4,16}$/.test(id)){
			$('#idSpan').html("아이디는 4자~16자를 입력 해야 합니다.");
			return false;
		}
		if(/^[a-z0-9]{4,16}$/.test(id)){
			$('#idSpan').html("완벽한 아이디입니다.");
			return false;
		}
		
	});
	$('#password').keyup(function(){
		var password = document.getElementById('password').value;
		var checkNumber = password.search(/[0-9]/g);
		var checkEnglish = password.search(/[a-zA-Z]/g);
		var checkCha= password.search(/[!@#$%^&*()]/g);	
		
	 		if(checkNumber+checkEnglish+checkCha < 2){
	 			$('#passSpan').html("영문 대소문자/숫자/특수문자 중 2가지 이상 조합이여야 합니다");
	 			return false;
	 		}
	 		if(!/^[a-zA-Z0-9!@#$%^&*()]{8,16}$/.test(password)){
	 			$('#passSpan').html("비밀번호는 8자~16자을 입력해야 합니다.");
	 			return false;
	 		}
	 		if(/^[a-zA-Z0-9!@#$%^&*()]{8,16}$/.test(password)){
	 			$('#passSpan').html("완벽한 비밀번호 입니다.");
	 			return false;
	 		}
	});
});