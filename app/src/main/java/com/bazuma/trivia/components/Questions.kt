package com.bazuma.trivia.components

import android.graphics.ComposePathEffect
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bazuma.trivia.screens.QuestionViewModel
import com.bazuma.trivia.util.AppColors


@Composable
fun Questions(viewModel: QuestionViewModel) {
    val question =viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true){
        CircularProgressIndicator()
    }else{
        question?.forEach { questionItem ->

        }
    }
}

//@Preview
@Composable
fun QuestionDisplay(){
    val pathEffect=PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(4.dp),
        color = AppColors.mDarkPurple
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            QuestionTracker()
            DrawDottedLine(pathEffect )

        }
    }
}

@Composable
fun DrawDottedLine(pathEffect: PathEffect){
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp),

        ){
          drawLine(
              color=AppColors.mLightGray,
              start = Offset(0f,0f),
              end = Offset(size.width,y=0f),
              pathEffect=pathEffect
          )
    }
}


@Preview
@Composable
fun QuestionTracker(counter:Int=10,
                    outOf:Int=100){
  Text(text = buildAnnotatedString {
      withStyle(style = ParagraphStyle(textIndent = TextIndent.None)){
         withStyle(style= SpanStyle(color=AppColors.mLightGray,
           fontWeight = FontWeight.Bold, fontSize = 27.sp)){
             append("Question $counter/")
             withStyle(style = SpanStyle(color=AppColors.mLightGray,
                fontWeight = FontWeight.Bold, fontSize = 27.sp)){
                 append("$outOf")
          }

          }
      }
  }, modifier = Modifier.padding(20.dp))

}