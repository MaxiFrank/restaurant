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
async function loadMenuItems ()
{
    const response = await fetch( 'http://localhost:8080/dish/' ).then( response => response.json() )
    console.log( response )
    const menuItemsList = document.body.querySelector( '#menu-items' )
    for ( const element of response )
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

function formatTimeRangeToStartTimeOnly ( timeRange )
{
    // Split the range and get the first part
    let startTime24 = timeRange.split( "-" )[ 0 ]

    // Create a Date object at today's date and the given time
    let date = new Date( `1970-01-01T${ startTime24 }:00` )

    // Format the time in 12-hour format with AM/PM
    let hours = date.getHours()
    let minutes = date.getMinutes()
    let ampm = hours >= 12 ? 'PM' : 'AM'
    hours = hours % 12
    hours = hours ? hours : 12 // the hour '0' should be '12'
    minutes = minutes < 10 ? '0' + minutes : minutes
    let strTime = hours + ':' + minutes + ' ' + ampm

    return strTime
}

initAvailabilitySelect = ( availability ) =>
{
    const partySizeSelect = document.getElementById( "partySizeSelect" )
    const timeSelect = document.getElementById( "timeSelect" )
    timeSelect.hidden = true
    const bookReservationButton = document.getElementById( 'bookReservationButton' )
    bookReservationButton.disabled = true

    const capacities = availability.map( function ( item )
    {
        return item.capacity
    } )
    const uniqueCapacities = Array.from( new Set( capacities ) )

    partySizeSelect.innerHTML = ""
    const option = document.createElement( "option" )
    partySizeSelect.appendChild( option )
    for ( let i = 0; i < uniqueCapacities.length; i++ )
    {
        const option = document.createElement( "option" )
        option.value = uniqueCapacities[ i ]
        option.text = uniqueCapacities[ i ] + " people"
        partySizeSelect.appendChild( option )
    }

    partySizeSelect.addEventListener( "change", function ( event )
    {
        const selectedOption = partySizeSelect.options[ partySizeSelect.selectedIndex ]
        // Enable and update time select with available times for party size
        const timeOptionsForSelectedCapacity = availability.filter( function ( item )
        {
            return item.capacity == selectedOption.value
        } )

        // Only need to display one unique time per table size
        const uniqueValues = {}
        const uniqueTimeOptionsForSelectedCapacity = timeOptionsForSelectedCapacity.filter( function ( item )
        {
            if ( !uniqueValues[ item.timeSlot ] )
            {
                uniqueValues[ item.timeSlot ] = true
                return true
            }
            return false
        } )

        // Clean up nodes
        timeSelect.innerHTML = ""
        document.getElementById( "timeSelectLabel" ).hidden = false

        // Add new nodes to time chip select
        for ( let i = 0; i < uniqueTimeOptionsForSelectedCapacity.length; i++ )
        {
            const input = document.createElement( "input" )
            const label = document.createElement( "label" )

            input.type = "radio"
            input.id = "option" + ( i + 1 )
            input.name = "chip"
            input.value = uniqueTimeOptionsForSelectedCapacity[ i ].id

            label.htmlFor = input.id
            label.textContent = formatTimeRangeToStartTimeOnly( uniqueTimeOptionsForSelectedCapacity[ i ].timeSlot )

            timeSelect.appendChild( input )
            timeSelect.appendChild( label )
        }

        timeSelect.hidden = false

        const radioInputs = document.querySelectorAll( 'input[name="chip"]' )
        radioInputs.forEach( ( input ) =>
        {
            input.addEventListener( 'change', () =>
            {
                bookReservationButton.disabled = false
            } )
        } )
    } )
}

function getCurrentDateStringDatepickerFormat ()
{
    const currentDate = new Date()
    const year = currentDate.getFullYear()
    const month = String( currentDate.getMonth() + 1 ).padStart( 2, '0' )
    const day = String( currentDate.getDate() ).padStart( 2, '0' )

    return `${ year }-${ month }-${ day }`
}

fetchAvailability = () =>
{
    const date = document.getElementById( "datePicker" ).value
    let currentHour = new Date().getHours().toString().padStart( 2, '0' )
    let currentMinute = new Date().getMinutes().toString().padStart( 2, '0' )
    let afterTime = `${ currentHour }:${ currentMinute }`
    if ( date != getCurrentDateStringDatepickerFormat() )
    {
        afterTime = "00:00"
    }
    const url = `http://localhost:8080/availability/?date=${ date }&afterTime=${ afterTime }`

    fetch( url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    } )
        .then( response =>
        {
            if ( !response.ok )
            {
                throw new Error( 'Network response was not ok' )
            }
            return response.json()
        } )
        .then( data =>
        {
            console.log( data )
            initAvailabilitySelect( data )
        } )
        .catch( error =>
        {
            console.error( 'There has been a problem with your fetch operation:', error )
        } )
}

function initDatepickerToToday ()
{
    const today = new Date()
    const dd = String( today.getDate() ).padStart( 2, '0' )
    const mm = String( today.getMonth() + 1 ).padStart( 2, '0' ) //January is 0!
    const yyyy = today.getFullYear()

    const todayString = yyyy + '-' + mm + '-' + dd
    document.getElementById( "datePicker" ).value = todayString
}

function listenForBookingSubmit ()
{
    const bookReservationButton = document.getElementById( 'bookReservationButton' )
    bookReservationButton.addEventListener( 'click', () =>
    {
        const selectedAvailabilityId = document.querySelector( 'input[name="chip"]:checked' ).value
        const selectedDate = document.getElementById( "datePicker" ).value
        console.log( selectedAvailabilityId )

        const url = `http://localhost:8080/reservation/create`
        const data = {
            availabilityId: selectedAvailabilityId,
            date: selectedDate
        }

        fetch( url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify( data ),
        } )
            .then( response =>
            {
                if ( !response.ok )
                {
                    throw new Error( 'Network response was not ok' )
                }
                return response.json()
            } )
            .then( data =>
            {
                console.log( data )
                alert( "Reservation booked!" )
                resetReservationForm()
            } )
            .catch( error =>
            {
                console.error( 'There has been a problem with your fetch operation:', error )
            } )
    } )
}

function resetReservationForm ()
{
    initDatepickerToToday()
    fetchAvailability()
}

function listenForDatepickerChange ()
{
    const datePicker = document.getElementById( "datePicker" )
    datePicker.addEventListener( "change", function ( event )
    {
        fetchAvailability()
    } )
}

function initializeReservationForm ()
{
    initDatepickerToToday()
    listenForDatepickerChange()
    fetchAvailability()
    listenForBookingSubmit()
}

window.addEventListener( 'DOMContentLoaded', event =>
{
    initializeReservationForm()

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