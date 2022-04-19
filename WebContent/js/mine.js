$(function() {

	var idCheck = false;
	var idCheckResult = false;


	$('#homeBtn').click(function() {


		location.href = "index.jsp";





	})

	$('#idCheckBtn').click(function() {
		idCheck = true;
		var user_id = $('#user_id').val();

		$.ajax({

			url: "idCheckProcess.jsp",
			type: 'post',
			data: { user_id: user_id },
			success: function(data) {
				if (data.trim() == 'Dup') {
					alert('아이디가 중복됩니다');
				} else {
					alert('아이디가 사용가능합니다');
					idCheckResult = true;
				}
			},
			error: function(request, status, error) {
				consol.log("code:" + request.status + "\n" +
					"message:" + request.responseText + "\n" +
					"error:" + error);
			}
		});
	});

	$('#userRegForm').submit(function(e) {


		var user_id = $('#user_id').val()
		var user_pw = $('#user_pw').val()
		var user_re_pw = $('#user_re_pw').val()


		if (user_id == null || user_id.trim() == "") {
			alert('아이디를 입력해주세요');
			return;

		}

		if (user_pw == null || user_pw.trim() == "") {
			alert('비밀번호를 입력해주세요');
			return;
		}
		if (user_re_pw == null || user_re_pw.trim() == "") {
			alert('비밀번호를 입력해주세요');
			return;
		}
		if (user_pw != user_re_pw) {
			alert('비밀번호가 일치하지 않습니다');
			return;
		}

		if (idCheck == false) {
			alert('아이디 중복 체크를 누르셔야 합니다.');
			return;
		}
		if (idCheckResult == false) {
			alert('아이디가 중복됩니다');
			return;
		}

		$('#userRegForm').attr('action', 'loginProcess.jsp');
		$('#userRegForm').attr('method', 'post');



	});

	$('#loginBtn').click(function(e) {

		var user_id = $('#user_id').val()
		var user_pw = $('#user_pw').val()

		if (user_id == null || user_id.trim() == "") {
			alert('아이디를 입력해주세요');
			return;

		}

		if (user_pw == null || user_pw.trim() == "") {
			alert('비밀번호를 입력해주세요');
			return;
		}

		$.ajax({

			url: "newLoginProcess.jsp",
			type: 'post',
			data: {
				user_id: user_id,
				user_pw: user_pw
			},
			success: function(data) {
			

				if (data.trim() == 'Success') {
					location.href = 'index.jsp';
				}else{
					alert('아이디나 비밀번호 확인해주세요');
				}


			},
			error: function(request, status, error) {
				consol.log("code:" + request.status + "\n" +
					"message:" + request.responseText + "\n" +
					"error:" + error);
			}
		});



	})



})