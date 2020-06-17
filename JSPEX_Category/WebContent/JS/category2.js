
$(document).ready(function(){
   
   loadParent();
   
   optionListSecond();
   

   
})

// 페이지 로드되면 selectbox 살리고 안에 부모 설정하기
function loadParent(){
   $.ajax({
      url : "cate_list.ajax?&depth=1&parent=0"
      , type : "GET"
      , success : function(data, status){
         if(status == "success"){
            optionsList(data);
         } // if(status)
      }
   });
   
}

function optionsList(data){
   if(data.status == "SUCCESS"){
      var selectFirst = $("#mycate span:first-child select");
      var options = "<option data-depth='0' value='0'>--선택해주세요--</option>";
      var i;
      for(i = 0; i < data.count; i++){
         options += "<option data-depth='" + data.list[i].depth + "' value='" + data.list[i].uid + "'>" + data.list[i].name + "</option>";
      }
      selectFirst.html(options);
      selectFirst.attr("disabled", false);
   } else {
      alert(data.status);
      return false;
   }
   return false;
} 

function optionListSecond(){
   $("#mycate select").change(function(){
      alert($(this).find(":selected").text());
      var firstOption = $(this).val();
      $.ajax({
         url : "cate_list.ajax?depth=" + $(this).find(":selected").attr("data-depth") + "&parent=" + firstOption 
         , type : "GET"
         , cache : false
         , success : function(data, status){
            if(status == "success"){
               if(data.status == "SUCCESS"){
                  var selectSec = $("#mycate select:odd");
                  var selectThird = $("#mycate select").last();
                  var options = ""
                 options += "<option data-depth='0' value='0'>--선택해주세요--</option>";
                  var i;
                  for(i = 0; i < data.count; i++){
                     options += "<option data-depth='" + data.list[i].depth + "' value='" + data.list[i].uid + "'>" + data.list[i].name + "</option>";
                  }
                  selectSec.html(options);
                  $("#mycate select:odd").attr("disabled", false);
                  loadThird(data);
               } else{
                  $("#mycate select:odd").attr("disabled", true);
               }
            } 
         } 
      })
      
   });
}

function loadThird(data){
   var selectThird = $("#mycate select").last();
   var options = "<option data-depth='0' value='0'>--선택해주세요--</option>";
   var i;
   for(i = 0; i < data.count; i++){
      options += "<option data-depth='" + data.list[i].depth + "' value='" + data.list[i].uid + "'>" + data.list[i].name + "</option>";
   }
   selectThird.html(options);
   selectThird.attr("disabled", false);
};

   
   