package com.example.newquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
//
class QuizQuestion : AppCompatActivity(), View.OnClickListener {

    private var mUserName:String? = null
    private var mCurrentAnswer: Int = 0
//


    private var tvprogressBar: ProgressBar? = null
    private var tvtextProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var tvivImage: ImageView? = null
    private var tvoptionOne: TextView? = null
    private var tvoptionTwo: TextView? = null
    private var tvoptionThree: TextView? = null
    private var tvoptionFour: TextView? = null
    private var tvbtnSubmit: Button? = null

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        tvprogressBar = findViewById(R.id.progressBar)
        tvtextProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tvQuesTion)
        tvivImage = findViewById(R.id.tvImage)
        tvoptionOne = findViewById(R.id.tv_optionOne)
        tvoptionTwo = findViewById(R.id.tv_optionTwo)
        tvoptionThree = findViewById(R.id.tv_optionThree)
        tvoptionFour = findViewById(R.id.tv_optionFour)
        tvbtnSubmit = findViewById(R.id.btnSubmit)
        mQuestionList = Constants.getQuestions()


        setQuestion()

        tvoptionOne?.setOnClickListener(this)
        tvoptionTwo?.setOnClickListener(this)
        tvoptionThree?.setOnClickListener(this)
        tvoptionFour?.setOnClickListener(this)
        tvbtnSubmit?.setOnClickListener(this)




    }

    private fun setQuestion() {



        val question: Question = mQuestionList!![mCurrentPosition - 1]
        defaultOptionView()
        if (mCurrentPosition == mQuestionList!!.size) {
            tvbtnSubmit?.text = "Finish"
        } else {
            tvbtnSubmit?.text = "Submit"
        }

        tvprogressBar?.progress = mCurrentPosition
        tvivImage?.setImageResource(question.image)
        tvtextProgress?.text = "$mCurrentPosition" + "/" + tvprogressBar?.max
        tvQuestion?.text = question.question
        tvoptionOne?.text = question.firstoptionOne
        tvoptionTwo?.text = question.sevcondoptionTwo
        tvoptionThree?.text = question.thirdoptionThree
        tvoptionFour?.text = question.fourthoptionFour

    }

    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {
            1 -> {
                tvoptionOne?.background = ContextCompat.getDrawable(
                    this@QuizQuestion, drawableView)
            }
            2 -> {
                tvoptionTwo?.background = ContextCompat.getDrawable(
                    this@QuizQuestion, drawableView)
            }
            3 -> {
                tvoptionThree?.background = ContextCompat.getDrawable(
                    this@QuizQuestion, drawableView)
            }
            4 -> {
                tvoptionFour?.background = ContextCompat.getDrawable(
                    this@QuizQuestion, drawableView)
            }
        }
    }
//
    private fun selectedOptionView(tv: TextView, selectedNum: Int) {

        defaultOptionView()

        mSelectedOptionPosition = selectedNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background =
            ContextCompat.getDrawable(
                this@QuizQuestion, R.drawable.selected_option_border_bg
            )
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()

        tvoptionOne?.let {
            options.add(0, it)
        }
        tvoptionTwo?.let {
            options.add(1, it)
        }
        tvoptionThree?.let {
            options.add(2, it)
        }
        tvoptionFour?.let {
            options.add(3, it)
        }
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizQuestion, R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_optionOne -> {
                tvoptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tv_optionTwo -> {
                tvoptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_optionThree -> {
                tvoptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_optionFour -> {
                tvoptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btnSubmit -> {
                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, Result_Activity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CURRENT_QUESTION, mCurrentAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.currentAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_answer)
                    }else{
                        mCurrentAnswer++
                    }
                    answerView(question.currentAnswer, R.drawable.correct_answer)
                    if (mCurrentPosition == mQuestionList!!.size) {
                        tvbtnSubmit?.text = "Finish"
                    } else {
                        tvbtnSubmit?.text = "Go to next Question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
}

