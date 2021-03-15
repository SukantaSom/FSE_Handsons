function validateForm() {
	var title = document.forms["editMovieForm"]["title"].value;
    var boxOffice = document.forms["editMovieForm"]["boxOffice"].value;
	var dateOfLaunch = document.forms["editMovieForm"]["dateOfLaunch"].value;
	var genre = document.forms["editMovieForm"]["genre"].value;
	
	var titleError = document.getElementById("title-error");
	var boxOfficeError = document.getElementById("boxOffice-error")
	var dateOfLaunchError = document.getElementById("dateOfLaunch-error")
	var genreError = document.getElementById("genre-error")
	
	var datePattern = /^\d{2}\/\d{2}\/\d{4}$/;
	//var error = "";
	var formStatus = true;
	
	titleError.innerHTML = "";
	boxOfficeError.innerHTML = "";
	dateOfLaunchError.innerHTML = "";
	genreError.innerHTML = "";
	
	//title validation
	if(title.length < 2 || title.length > 100) {
		if(title.length == 0) {
			//error = "!!  Title is required.\n";
			titleError.innerHTML = "! Title is required.<br>";
			formStatus = false;
		}
		//error += "!!  Title should have 2 to 100 characters.\n";
		titleError.innerHTML += "! Title should have 2 to 100 characters.\n";
		formStatus = false;
	}
	
	//boxOffice validation
	if(boxOffice.length == 0) {
		//error += "!!  Box Office is required.\n";
		boxOfficeError.innerHTML = "! Box Office is required.";
		formStatus = false;
	}	else {
		if(isNaN(boxOffice)) {
			//error += "!!  Box Office has to be a number.\n";
			boxOfficeError.innerHTML = "! Box Office has to be a number.";
			formStatus = false;
		}
	}
	
	//date of launch validation
	if(dateOfLaunch.length == 0) {
		//error += "!!  Date of Launch is required.\n";
		dateOfLaunchError.innerHTML = "! Date of Launch is required.<br>";
		formStatus = false;
	}
	if(!datePattern.test(dateOfLaunch)) {
		//error += "!! Date of Launch should be in format dd/mm/yyyy\n";
		dateOfLaunchError.innerHTML += "! Date of Launch should be in format dd/mm/yyyy";
		formStatus = false;
	}	else {
		if(dateOfLaunch.substring(0,2) < 1 || dateOfLaunch.substring(0,2) > 31) {
			//error += "!! Invalid value for day: " + dateOfLaunch.substring(0,2) + "\n";
			dateOfLaunchError.innerHTML = "! Invalid value for day: " + dateOfLaunch.substring(0,2) + "<br>";
			formStatus = false;
		}
		if(dateOfLaunch.substring(3,5) < 1 || dateOfLaunch.substring(3,5) > 12) {
			//error += "!! Invalid value for month: " + dateOfLaunch.substring(3,5) + "\n";
			dateOfLaunchError.innerHTML += "! Invalid value for month: " + dateOfLaunch.substring(3,5);
			formStatus = false;
		}
	}
	
	//genre validation
	if(genre == "select") {
		//error += "!!  Select one genre.";
		genreError.innerHTML = "! Select one genre.";
		formStatus = false;
	}
	
	//alert(error);
	return formStatus;
}