package com.example.newquizapp

object Constants {

    const val USER_NAME: String ="user_name"
    const val TOTAL_QUESTION: String ="total_question"
    const val CURRENT_QUESTION: String ="current_question"

    fun getQuestions(): ArrayList<Question>{

        val questionlist = ArrayList<Question>()

        val ques1 = Question(
            1, "What is the name of this beautiful Bird?",
            R.drawable.cardinal, "Cardinal", "Flamingo",
            "Kingfisher"
        , "Owl"
        , 1
        )
        questionlist.add(ques1)
        val ques2 = Question(
            2, "What is the name of this beautiful Bird?",
            R.drawable.kingfisher, "Cardinal", "Kingfisher",
            "Hummingbird"
            , "Owl"
            , 2
        )
        questionlist.add(ques2)
        val ques3 = Question(
            3, "What is the name of this beautiful Bird?",
            R.drawable.hummingbird, "Cardinal", "Flamingo",
            "Hummingbird"
            , "Kingfisher"
            , 3
        )
        questionlist.add(ques3)
        val ques4 = Question(
            4, "What is the name of this beautiful Bird?",
            R.drawable.swan, "Cardinal", "Swan",
            "Hummingbird"
            , "Owl"
            , 2
        )
        questionlist.add(ques4)
        val ques5 = Question(
            5, "What is the name of this beautiful Bird?",
            R.drawable.flamingo, "Kingfisher", "Flamingo",
            "Hummingbird"
            , "Owl"
            , 2
        )
        questionlist.add(ques5)
        val ques6 = Question(
            6, "What is the name of this beautiful Bird?",
            R.drawable.bird, "Churoi Paki", "Flamingo",
            "Hummingbird"
            , "Owl"
            , 1
        )
        questionlist.add(ques6)
        val ques7 = Question(
            7, "What is the name of this beautiful Bird?",
            R.drawable.owl, "Cardinal", "Swan",
            "Hummingbird"
            , "Owl"
            , 4
        )
        questionlist.add(ques7)
        val ques8 = Question(
            8, "What is the name of this beautiful Bird?",
            R.drawable.ducks, "Swan", "Flamingo",
            "Hummingbird"
            , "Ducks"
            , 4
        )
        questionlist.add(ques8)
        val ques9 = Question(
            9, "What is the name of this beautiful Bird?",
            R.drawable.chaffinch, "Flamingo", "Chaffinch",
            "Hummingbird"
            , "Owl"
            , 2
        )
        questionlist.add(ques9)
        val ques10 = Question(
            10, "What is the name of this beautiful Bird?",
            R.drawable.swan, "Cardinal", "Flamingo",
            "Swan"
            , "Owl"
            , 3
        )
        questionlist.add(ques10)

        return questionlist
    }

}