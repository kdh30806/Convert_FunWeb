$(document).ready(function() {	
	$('#join').submit(function(){
		
		var id = document.getElementById('id').value;
		var password = document.getElementById('password').value;
		
		if($('#id').val()==""){
			alert("아이디 입력하세요");
			$('#id').focus();
			return false;
		}
		
		if(!/^[a-z0-9]{4,16}$/.test(id)){
			alert("아이디 양식을 확인해주세요.");
			$('#id').focus();
			return false;
		}
		
		if($('#password').val()==""){
			alert("비밀번호 입력하세요");
			$('#password').focus();
			return false;
		}
		
		if(!/^[a-zA-Z0-9!@#$%^&*()]{8,16}$/.test(password)){
			alert("비밀번호 양식을 확인해주세요.");
			$('#id').focus();
			return false;
		}
		
		if($('#password').val() != $('#password2').val()){
	 		alert("패스워드가 일치하지 않습니다.");
	 		return false;
	 	}
		
		if($('#name').val()==""){
			alert("이름 입력하세요");
			$('#name').focus();
			return false;
		}
		
		if($('#mobile2').val()==""){
			alert("전화번호를 입력하세요");
			$('#mobile2').focus();
			return false;
		}
		
		if($('#mobile3').val()==""){
			alert("전화번호를 입력하세요");
			$('#mobile3').focus();
			return false;
		}
		
		if($('#phone2').val()==""){
			alert("휴댜폰번호를 입력하세요");
			$('#phone2').focus();
			return false;
		}
		
		if($('#phone3').val()==""){
			alert("휴댜폰번호를 입력하세요");
			$('#phone3').focus();
			return false;
		}
		
		if($('#email').val()==""){
			alert("이메일 입력하세요");
			$('#email').focus();
			return false;
		}
		});
	});