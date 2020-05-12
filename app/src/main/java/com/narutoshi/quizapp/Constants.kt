package com.narutoshi.quizapp

object Questions {
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        questionList.add(
            Question(
                1,
                "What country does this flag belong to?",
                R.drawable.ic_flag_of_argentina,
                "Argentina",
                "Australia",
                "Armenia",
                "Austria",
                1
            )
        )

        questionList.add(
            Question(
                2, "What country does this flag belong to?",
                R.drawable.ic_flag_of_australia,
                "Angola", "Austria",
                "Australia", "Armenia", 3
            )
        )

        questionList.add(
            Question(
                3, "What country does this flag belong to?",
                R.drawable.ic_flag_of_brazil,
                "Belarus", "Belize",
                "Brunei", "Brazil", 4
            )
        )

        questionList.add(
            Question(
                4, "What country does this flag belong to?",
                R.drawable.ic_flag_of_belgium,
                "Bahamas", "Belgium",
                "Barbados", "Belize", 2
            )
        )

        questionList.add(
            Question(
                5, "What country does this flag belong to?",
                R.drawable.ic_flag_of_fiji,
                "Gabon", "France",
                "Fiji", "Finland", 3
            )
        )

        questionList.add(
            Question(
                6, "What country does this flag belong to?",
                R.drawable.ic_flag_of_germany,
                "Germany", "Georgia",
                "Greece", "none of these", 1
            )
        )

        questionList.add(
            Question(
                7, "What country does this flag belong to?",
                R.drawable.ic_flag_of_denmark,
                "Dominica", "Egypt",
                "Denmark", "Ethiopia", 3
            )
        )

        questionList.add(
            Question(
                8, "What country does this flag belong to?",
                R.drawable.ic_flag_of_india,
                "Ireland", "Iran",
                "Hungary", "India", 4
            )
        )

        questionList.add(
            Question(
                9, "What country does this flag belong to?",
                R.drawable.ic_flag_of_new_zealand,
                "Australia", "New Zealand",
                "Tuvalu", "United States of America", 2
            )
        )

        questionList.add(
            Question(
                10, "What country does this flag belong to?",
                R.drawable.ic_flag_of_kuwait,
                "Kuwait", "Jordan",
                "Sudan", "Palestine", 1
            )
        )

        return questionList
    }
}