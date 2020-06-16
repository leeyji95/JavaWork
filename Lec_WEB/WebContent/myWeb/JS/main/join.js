function chkSubmit() {
    var frm = document.forms['join_box'];

    if (frm['userEmail'].value.trim() == "") {
        alert("이메일을 입력해주세요");

        frm['userEmail'].focus()
        return false;
    }
    if (frm["service_ck"].checked == false) {
        alert("서비스 이용약관에 동의하세요.")
        return false;
    }
    if (frm["privacy_ck"].checked == false) {
        alert("개인정보 수집 및 이용에 동의하세요.")
        return false;
    }

    return true; // onsubmit 에 true를 리턴하면 submit 진행된다 
}

// $(document).ready(function () {


//     $("#join_box").submit(function (e) {
//         e.preventDefault();


//         if ($("#input01").val().trim() == "") {
//             alert("이메일을 입력해주시기 바랍니다.");

//             $("#input01").focus();
//             return false;
//         }

//         if ($("input:checkbox[name=service_ck]").is(":checked") == false) {
//             alert("서비스 이용약관에 동의하세요.")
//             return false;
//         }

//         if ($("input:checkbox[name=privacy_ck]").is(":checked") == false) {
//             alert("개인정보 수집 및 이용에 동의하세요.")
//             return false;
//         }

//         return true;
//     });



//     $("input[type=submit]").click(function (e) { 
//         e.preventDefault();
//         $("#join_box").submit();
//     });






//     // 전체동의 클릭시
//     $("#chkAll").click(function (e) { 
//         e.preventDefault();

//         // 모두 선택
//         $("input[type=checkbox]").prop("checked", true);
//     });



// });