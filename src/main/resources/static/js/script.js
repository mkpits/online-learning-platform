 // about page js
$(document).ready(function () {
    // Activate the carousel
    $('#courseCarousel').carousel();

    // Automatically slide to the next set every 2 seconds
    setInterval(function () {
        $('#courseCarousel').carousel('next');
    }, 3500);
});