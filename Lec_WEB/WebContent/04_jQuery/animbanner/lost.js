(function(){
    // 바다
    var $waterFront = $("#water-front");
    var $waterBack = $("#water-back");

    (function loopSea(){
        $waterFront
          .animate({'bottom' : '-65px', 'left' : '-30px'}, 500)
          .animate({'bottom' : '-60px', 'left' : '-25px'}, 500);
        $waterBack
          .animate({'bottom' : '15px', 'left' : '-20px'}, 500)
          .animate({'bottom' : '10px', 'left' : '-25px'}, 500);
          $.when($waterFront, $waterBack).done(loopSea);  // 프론트, 백  두개 다 끝나면 -> 실행하세요
    })();
    
    
    // 구름
    var $cloud1 = $('#cloud-group-1');
    var $cloud2 = $('#cloud-group-2');
    
    (function loopCloud(){
        $cloud1
            .animate({'left' : '-720px'}, 10000)
            .animate({'left' : '0px'}, 0);  // 다시 제자리로 후딱 돌아옴.
        $cloud2
            .animate({'left' : '0px'}, 10000) // 첫번쨰 구름이 가는 동안 멈추있다가
            .animate({'left' : '720px'}, 0, loopCloud); // 10000 지나고, 오른쪽으로(?) 움직인다? 
    })();
    
    

    // 보트 (페이지 로딩될 때 단 한번만 <왼쪽에서 오른쪽으로 움직이는> 효과 주기)  ->페이지 로딩될 때까지 니까,  JS 에서 작성해준다.
    var $boat = $("#boat");
    var $questionMark = $("#question-mark");
    var $title1 = $('#title1');
    var $title2 = $('#title2');
    var $form = $('#form');

    $boat.css({'left':'-220px'}); //  최초, 화면 왼쪽 바깥 위치
    $questionMark.css({'opacity':0}); // 물음표 마크 존재는 하나, 투명으로 적용시켜 보이지 않음
    $title1.css({'opacity' : 0});
    $title2.css({'opacity' : 0});
    $form.css({'left': '370px'}); /* 완전 옆으로 내보낸다(안보이게하다가) */


    // 방법1 : animate() + callback 사용
    // $boat.animate({'left' : '20px'}, 2000, function(){
    //     loopBoat();
    //     $questionMark.delay(500).animate({'opacity' : 1}, 1000, function(){
    //         $title1.animate({'opacity': 1}, 1000, function(){
    //             $title2.animate({'opacity' : 1}, 1000, function(){
    //                 $form.animate({'left': 0}, 500);
    //             });// end $title2
    //         });// end $title1
    //     }); // end $questionMark    
    // });  //end $boat

    // 방법2 : $.when() 사용  .then() 사용    
    /* $.when($boat.animate({'left':'20px'}, 2000))
        .then(function(){
            loopBoat();
            return $.when($questionMark.delay(500).animate({'opacity':1}, 1000));
        })
        .then(function(){
            return $.when($title1.animate({'opacity': 1}, 1000));
        })
        .then(function(){
            return $.when($title2.animate({'opacity' : 1}, 1000));
        })
        .then(function(){
            $.when($form.animate({'left': 0}, 500, reload));  // 마지막은 return 하지 않아도 됨. 
        })
        ;

        // return 사용시 -> 순차적으로 실행

        function reload(){
            setTimeout(function(){ // 5초 뒤, 이 함수 수행한다.
                location.reload();
            }, 5000);  
        } */

        // 방법3 : 단일 애니메이션의 연속인 경우 promise() 만으로 가능
        $boat.animate({'left':'20px'}, 2000).promise()
        .then(function(){
            loopBoat();
            return $questionMark.delay(500).animate({'opacity':1}, 1000).promise;
        })
        .then(function(){
			return $title1.animate({'opacity' : 1}, 1000).promise();
		})
		.then(function(){
			return $title2.animate({'opacity' : 1}, 1000).promise();
		})
		.done(function(){
			$form.animate({'left' : 0}, 500);
		})
        ;
        
    function loopBoat(){
        $boat
            .animate({'bottom': '15px'}, 500)
            .animate({'bottom':'25px'},500, loopBoat)
    }
})() // 이름 없는 함수를 호출













