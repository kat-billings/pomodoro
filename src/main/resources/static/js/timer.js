function timer(time, id){
    document.getElementById(id).style.display = "none";
    var start = new Date().getTime();

    var x = setInterval(function() {
        var countDownDate = new Date(start + (time * 60 * 1000));;
        var now = new Date().getTime();
        var distance = countDownDate - now;

        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((distance % (1000 * 60)) / 1000);

         document.getElementById("time").innerHTML = minutes + "m " + seconds + "s ";

           if (distance < 0) {
                clearInterval(x);
                if (id === "workButton") {
                    document.getElementById("time").innerHTML = "Good job!";
                    document.getElementById("breakButton").style.display = "block";
                } else {
                    document.getElementById("time").innerHTML = "Start a new block!";
                    document.getElementById("workButton").style.display = "block";
                }
           }
        }, 1000);
     }