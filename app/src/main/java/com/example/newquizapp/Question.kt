package com.example.newquizapp

data class Question(
    var id: Int,
    var question: String,
    var image : Int,
    var firstoptionOne: String,
    var sevcondoptionTwo: String,
    var thirdoptionThree: String,
    var fourthoptionFour: String,
    var currentAnswer: Int
)
