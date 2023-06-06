/*!
* Start Bootstrap - Grayscale v7.0.6 (https://startbootstrap.com/theme/grayscale)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-grayscale/blob/master/LICENSE)
*/
//
// Scripts
//
initAvailabilitySelect = (availability) => {
    const partySizeSelect = document.getElementById("partySizeSelect");
    const timeSelect = document.getElementById("timeSelect");
    timeSelect.disabled = true;

    const capacities = availability.map(function(item) {
        return item.capacity;
    });
    const uniqueCapacities = Array.from(new Set(capacities));

    for (let i = 0; i < uniqueCapacities.length; i++) {
        const option = document.createElement("option");
        option.value = uniqueCapacities[i];
        option.text = uniqueCapacities[i];
        partySizeSelect.appendChild(option);
    }

    partySizeSelect.addEventListener("change", function(event) {
        const selectedOption = partySizeSelect.options[partySizeSelect.selectedIndex];
        // Enable and update time select with available times for party size
        const timeOptionsForSelectedCapacity = availability.filter(function(item) {
            return item.capacity == selectedOption.value;
        });

        for (let i = 0; i < timeOptionsForSelectedCapacity.length; i++) {
            const option = document.createElement("option");
            option.value = availability[i];
            option.text = availability[i].timeSlot;
            timeSelect.appendChild(option);
        }
        timeSelect.disabled = false;
    });
}

fetchAvailability = () => {
    console.log("Fetching availability");
    fetch('http://localhost:8080/availability/', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            initAvailabilitySelect(data);
        })
        .catch(error => {
            console.error('There has been a problem with your fetch operation:', error);
        });
}

createReservation = () => {

}

window.addEventListener('DOMContentLoaded', event => {
    fetchAvailability();

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            rootMargin: '0px 0px -40%',
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});