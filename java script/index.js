let countEs=document.getElementById("count-es")
let saveEl=document.getElementById("save-el")



console.log(countEs)
let count=0 // where you want your count to start

function inside(){
   // count=count+1  // each time it adds one. you could also use this method
   
    count +=1
    
    countEs.innerText=count // this allows you to appear whatever u want on the screen
  
}
function save() { // this section saves your previous number
    let countStr=count+ "-"
    saveEl.innerText +=countStr
   // countEl=innerText=0 //
    count=0 // this allows you to restarst everytime you save it 

}
    // create two functions add 3 points and remove pint and have them
    //add/remove points to/from my points variable
    // call the functions 10 times



//     let myPoints=3
//     function myPoints(){
//     myPoint=+3
//     }


//     function removePoints(){
//         myPoints -=1


//     }
//     add3Points()
//     add3Points()
//     add3Points()
//     removePoints()
//     removePoints()
// }
// console.log(myPoints)


// // imagine youre working on commercial website
// // and u want to tell when error occurs
// // first you name the function in the html
// //let errorParagraph = document.getElementById("error")


// console.log(errorParagraph) // we named the error as an element in html

// function purchase() {  // also we have purchase function with clicked button
//     console.log("button clicked")
//     errorParagraph.textContent = "Something went wrong, please try again"
// }

let num1 = 8
let num2 = 2
let num3=22
let num4=34
document.getElementById("num1-el").textContent = num1
document.getElementById("num2-el").textContent = num2
document.getElementById("num3-el").textContent = num3
document.getElementById("num4-el").textContent = num4




// creating a calculator

// Create four functions: add(), subtract(), divide(), multiply()
// Call the correct function when the user clicks on one of the buttons
// Perform the given calculation using num1 and num2
// Render the result of the calculation in the paragraph with id="sum-el"

// E.g. if the user clicks on the "Plus" button, you should render
// "Sum: 10" (since 8 + 2 = 10) inside the paragraph with id="sum-el"
// let sumEl = document.getElementById("sum-el")

function add() {
    let result=num1+num2+num3-num4
    sumEl.innerText="sum: " + result
}
function subtract() {
    let result=num1-num2-num3+num4
    sumEl.innerText="sum: " + result
}

    function multiply() {
        let result=num1*num2-num3+num4
        sumEl.innerText="sum: " + result
    }

        function divide() {
            let result=num1/num2-num3+num4
            sumEl.innerText="sum: " + result
        }


        // we want to create a blackjac game

        //first we nwant to get two different cards and add them
      
        let player={
            name:"Aj",
            price:145,
            
        }
        let cards = []
        let sum = 0
        let hasBlackJack = false
        let isAlive = false
        let message = ""
        let messageEl = document.getElementById("message-el")
        let sumEl = document.getElementById("sum-el")
        let cardsEl = document.getElementById("cards-el")
        let playerEl=document.getElementById("player-el")

        playerEl.textContent = player.name + ": £" + player.price
       // console.log(cards)
        
        
        function getRandomCard() {
            // if 1     -> return 11
            // if 11-13 -> return 10
            let randomNumer = Math.floor( Math.random()*13 ) + 1
            if (randomNumer > 10) {
                return 10
            } else if (randomNumer === 1) {
                return 11
            } else {
                return randomNumer
            }
        }
        
        function startGame() {
            isAlive=true
            let firstCard=getRandomCard()
            let secondCard=getRandomCard()
            //cards[firstCard,secondCard]
            sum= firstCard+secondCard

            renderGame()
        }
        
        function renderGame() {
            cardsEl.textContent = "Cards: "
            for (let i = 0; i < cards.length; i++) {
                cardsEl.textContent += cards[i] + " "
            }
            
            sumEl.textContent = "Sum: " + sum
            if (sum <= 20) {
                message = "Do you want to draw a new card?"
            } else if (sum === 21) {
                message = "You've got Blackjack!"
                hasBlackJack = true
            } else {
                message = "You're out of the game!"
                isAlive = false
            } 
            messageEl.textContent = message
        }
        
        
        function newCard() {
            if(isAlive===true &&hasBlackJack===false){
                

            }
            let card = getRandomCard()
            sum += card
            cards.push(card)
            renderGame()
        }
        let accountBalance = 1000;

        function checkAccountBalance() {
            console.log("Your account balance: $" + accountBalance);
        }
        
        function sendMoney(amount) {
            if (amount <= accountBalance) {
                accountBalance -= amount;
                console.log("You have sent $" + amount + " to the recipient.");
            } else {
                console.log("Insufficient funds. Unable to complete the transaction.");
            }
        }
        
        function startApplication() {
            document.getElementById("inputSection").style.display = "block";
        }
        
        function validateInputs() {
            const phoneNumber = document.getElementById("phoneNumber").value;
            const isValidPhoneNumber = /^\d{11}$/.test(phoneNumber);
        
            const amount = parseFloat(document.getElementById("amount").value);
            const isValidAmount = !isNaN(amount) && amount > 0 && amount <= accountBalance;
        
            if (isValidPhoneNumber && isValidAmount) {
                console.log("Dialing *712#...");
                console.log("Recipient's Phone Number: " + phoneNumber);
                checkAccountBalance();
                sendMoney(amount);
            } else {
                if (!isValidPhoneNumber) {
                    console.log("Invalid phone number. Please enter a 11-digit valid number.");
                }
                if (!isValidAmount) {
                    if (amount <= 0) {
                        console.log("Invalid amount. Please enter a number greater than 0.");
                    } else if (isNaN(amount)) {
                        console.log("Invalid amount. Please enter a valid number.");
                    } else if (amount > accountBalance) {
                        console.log("Invalid amount. You do not have enough funds in your account.");
                    } else {
                        console.log("Invalid amount. You cannot send more than your account balance.");
                    }
                }
            }
        }
        