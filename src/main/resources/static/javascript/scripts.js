/*!
* Start Bootstrap - Grayscale v7.0.6 (https://startbootstrap.com/theme/grayscale)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-grayscale/blob/master/LICENSE)
*/
//
// Scripts
//
/*
('ANTIPASTO MISTO', 'Grilled Eggplant, Zucchini, Salumi, Olives, Fior di Latte Mozzarella', 24.0),
('SUPPLI NAPOLETANA' , 'Fried Arborio Risotto Balls (3), Stuffed w/ Mozzarella, Served w/ Garlic-Aioli', 14.0),
('BURATA', 'Handmade Mozzarella w/ Marinated Olives, Greens, Frontoia Sicilian EVOO', 14.0),
*/
const dummyData = [
    {
        name: "ANTIPASTO MISTO",
        description: "Grilled Eggplant, Zucchini, Salumi, Olives, Fior di Latte Mozzarella",
        price: 24.0
    },
    {
        name: "SUPPLI NAPOLETANA",
        description: "Fried Arborio Risotto Balls (3), Stuffed w/ Mozzarella, Served w/ Garlic-Aioli",
        price: 14.0
    },
    {
        name: "BURATA",
        description: "Handmade Mozzarella w/ Marinated Olives, Greens, Frontoia Sicilian EVOO",
        price: 14.0
    },
]
console.log( dummyData )
function loadMenuItems ()
{
    const menuItemsList = document.body.querySelector( '#menu-items' )
    for ( const element of dummyData )
    {
        let htmlContent = `
        <div class="card menu-item-card h-100">
            <h4 class="card-header">${ element.name }</h4>
            <div class="card-body">
                <p class="card-text">${ element.description }</p>
            </div>
            <div class="card-footer">
                <strong>$${ element.price }</strong>
        </div>`
        menuItemsList.insertAdjacentHTML( 'beforeend', htmlContent )
    }

}
window.onload = loadMenuItems


window.addEventListener( 'DOMContentLoaded', event =>
{

    // Navbar shrink function
    var navbarShrink = function ()
    {
        const navbarCollapsible = document.body.querySelector( '#mainNav' )
        if ( !navbarCollapsible )
        {
            return
        }
        if ( window.scrollY === 0 )
        {
            navbarCollapsible.classList.remove( 'navbar-shrink' )
        } else
        {
            navbarCollapsible.classList.add( 'navbar-shrink' )
        }

    }

    // Shrink the navbar
    navbarShrink()

    // Shrink the navbar when page is scrolled
    document.addEventListener( 'scroll', navbarShrink )

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector( '#mainNav' )
    if ( mainNav )
    {
        new bootstrap.ScrollSpy( document.body, {
            target: '#mainNav',
            rootMargin: '0px 0px -40%',
        } )
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector( '.navbar-toggler' )
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll( '#navbarResponsive .nav-link' )
    )
    responsiveNavItems.map( function ( responsiveNavItem )
    {
        responsiveNavItem.addEventListener( 'click', () =>
        {
            if ( window.getComputedStyle( navbarToggler ).display !== 'none' )
            {
                navbarToggler.click()
            }
        } )
    } )

} )