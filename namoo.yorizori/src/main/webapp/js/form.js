document.querySelector("#recipeform").addEventListener("submit", function(event) {
	let time = document.querySelector("#recipe_time");
	let seqs = document.querySelectorAll("#seq_num");
	if(!time.value){
		time.value = 1;
	}
	for(var seq of seqs){
		if(!seq.value){
			seq.value = "수정필요";
		}
	}
	
})