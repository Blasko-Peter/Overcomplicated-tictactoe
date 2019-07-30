function checkthebutton (){
    let buttons = document.getElementsByClassName("checkthebutton");
    let winner = document.getElementById("winner").innerHTML;
    console.log(winner);
    let os = document.getElementsByClassName("fa-circle-o");
    let xs = document.getElementsByClassName("fa-times");
    let index = 0;
    for(let button of buttons){
        button.addEventListener("click", function () {
            let buttonId = button.getAttribute("id");
            for(let o of os){
                if(o.parentNode.id == buttonId){
                    index += 1;
                }
            }
            for(let x of xs){
                if(x.parentNode.id == buttonId){
                    index += 1;
                }
            }
            if(index == 0 && winner == ""){
                let url = "/game-move?move=" + buttonId;
                window.location = url;
            }
            index = 0;
        });
    }
}

checkthebutton ();