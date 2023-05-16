package com.bazuma.trivia.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.bazuma.trivia.components.Questions


@Composable
fun TriviaHome(viewModel: QuestionViewModel= hiltViewModel()){
    Questions(viewModel)
}