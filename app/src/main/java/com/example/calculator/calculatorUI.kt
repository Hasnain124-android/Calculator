package com.example.calculator


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


var operatorTrue: Boolean = false
@Composable
fun CalculatorInterface(){
    val col1 = listOf("C","7","4","1","%")
    val col2 = listOf("/","8","5","2","0")
    val col3 = listOf("*","9","6","3",".")
    val col4 = listOf("X","-","+")
    var contentText by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }



    //Outer Box
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        //Dividing Scree Into Two Parts
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            //Display box And Content
            Box(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxWidth(),

            ) {

                //Dividing Content Box Into Two Parts
                Column(modifier = Modifier
                    .fillMaxSize()) {
                    //Result Display Box
                    Box(
                        modifier = Modifier
                            .weight(0.6f)
                            .fillMaxWidth()
                            .background(Color.Transparent),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Text(text = result , modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Right, fontSize = 40.sp, color = Color.White,)
                    }
                    //Divider
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .background(Color.Black))
                    // Content Writing Box
                    Box(
                        modifier = Modifier
                            .weight(0.4f)
                            .fillMaxWidth()
                            .background(Color.Transparent),
                        contentAlignment = Alignment.BottomEnd
                    )
                    {

                        Text(text = contentText, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Right, fontSize = 25.sp, color = Color.White,)}
                }

            }

            //Box For buttons Parts
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),

                    )
                {
                    // column 1
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        repeat(5) { buttonIndex ->
                            Button(
                                onClick = {
                                    if (buttonIndex == 0)
                                    {
                                        contentText = ""
                                        result = ""
                                        operatorTrue = false
                                    }else{
                                    contentText += col1[buttonIndex]
                                    }
                                          },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = if (buttonIndex == 0) Color.Green else Color.White,
                                    containerColor = Color.Transparent
                                ),
                                shape = RectangleShape
                            ) { Text(text = col1[buttonIndex], fontSize = 20.sp, fontWeight = FontWeight.Bold) }
                        }

                    }

                    //column 2
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        repeat(5) { buttonIndex ->
                            Button(
                                onClick = {
                                    if(buttonIndex == 0)
                                    {
                                        if(operatorTrue){
                                            result = updateResult(contentText)
                                            if(result.equals("Error")){
                                                contentText = ""
                                            }else{
                                                contentText = result + col2[buttonIndex]
                                                operatorTrue =true
                                            }
                                        }else{
                                            contentText += col2[buttonIndex]
                                            operatorTrue = true
                                        }
                                    }else {
                                        contentText += col2[buttonIndex]
                                    }

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = if (buttonIndex == 0) Color.Green else Color.White,
                                    containerColor = Color.Transparent
                                ),
                                shape = RectangleShape
                            ) { Text(text = col2[buttonIndex], fontSize = 20.sp, fontWeight = FontWeight.Bold) }
                        }

                    }

                    //column 3
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        repeat(5) { buttonIndex ->
                            Button(
                                onClick = {
                                    if(buttonIndex == 0)
                                    {
                                        if(operatorTrue){
                                        result = updateResult(contentText)
                                            if(result.equals("Error")){
                                                contentText = ""
                                            }else{
                                                contentText = result + col3[buttonIndex]
                                                operatorTrue =true
                                            }
                                        }else{
                                        contentText += col3[buttonIndex]
                                        operatorTrue = true
                                        }
                                    }else {
                                        contentText += col3[buttonIndex]
                                    }

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = if (buttonIndex == 0) Color.Green else Color.White,
                                    containerColor = Color.Transparent
                                ),
                                shape = RectangleShape
                            ) { Text(text = col3[buttonIndex], fontSize = 20.sp, fontWeight = FontWeight.Bold) }
                        }

                    }

                    //column 4
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        repeat(3) { buttonIndex ->
                            Button(
                                onClick = {
                                    if(buttonIndex == 0)
                                    {
                                        contentText = contentText.dropLast(1)
                                    }
                                    else if(operatorTrue)
                                    {
                                        result = updateResult(contentText)
                                        if(result.equals("Error")){
                                            contentText = ""

                                        }else{
                                        contentText = result + col4[buttonIndex]
                                            operatorTrue =true}
                                    }else{
                                        contentText += col4[buttonIndex]
                                        operatorTrue = true
                                    }

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = Color.Green,
                                    containerColor = Color.Transparent
                                ),
                                shape = RectangleShape
                            ) { Text(text = col4[buttonIndex], fontSize = 20.sp, fontWeight = FontWeight.Bold) }
                        }

                        Button(
                            onClick = {
                                if(operatorTrue) {
                                    result = updateResult(contentText)
                                    if(result.equals("Error")){
                                        contentText = ""

                                    }else{
                                        contentText = result
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(2f),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.White,
                                containerColor = Color.Green
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(text = "=", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                        }
                    }
                }

            }
        }
    }
}



fun updateResult(data: String): String {
    // Split into numbers/operators
    val tokens = data.split(Regex("(?<=[+\\-*/])|(?=[+\\-*/])"))
        .filter { it.isNotBlank() }
        .toMutableList()

    // Merge negative numbers at the start
    if (tokens[0] == "-" && tokens.size > 1) {
        tokens[1] = "-" + tokens[1]
        tokens.removeAt(0)
    }

    // Merge negative numbers after an operator
    var i = 0
    while (i < tokens.size - 2) {
        if (tokens[i + 1] == "-" && tokens[i] in listOf("+", "-", "*", "/")) {
            tokens[i + 2] = "-" + tokens[i + 2]
            tokens.removeAt(i + 1)
        }
        i++
    }

    // Now tokens should look like: [number, operator, number]
    var result = 0
    try {
        if (tokens.size == 3) {
            val num1 = tokens[0].toInt()
            val op = tokens[1]
            val num2 = tokens[2].toInt()

            result = when (op) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> {
                    if (num2 != 0) num1 / num2 else return "Error"
                }
                else -> return "Error"
            }
        } else {
            return "Error"
        }
    } catch (e: Exception) {
        operatorTrue = false
        return "Error"
    }
    operatorTrue = false
    return result.toString()
}







