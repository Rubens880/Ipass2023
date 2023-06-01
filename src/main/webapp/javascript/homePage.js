const daysInMonth = (year, month) => new Date(year, month, 0).getDate();
const date = new Date();
const amountofDays = (daysInMonth(date.getFullYear(), date.getMonth()))

console.log(amountofDays);

let count = 0;


// Create the table
for (i = 0; i < amountofDays; i++) {
    
    count++;

    if (count == 8) {
        count = 0;
        console.log('volgende rij');
    }

    console.log(count + ', ' + i + ', ' + ', rows')


    console.log('hoi');
}