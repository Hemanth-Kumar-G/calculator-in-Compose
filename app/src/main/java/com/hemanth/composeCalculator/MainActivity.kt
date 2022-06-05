package com.hemanth.composeCalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hemanth.composeCalculator.ui.theme.ComposeCalculatorTheme
import com.hemanth.composeCalculator.ui.theme.LightGray
import com.hemanth.composeCalculator.ui.theme.MediumGray
import com.hemanth.composeCalculator.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Box(modifier = Modifier
                    .background(Color.LightGray)
                    .padding(10.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.spacedBy(buttonSpacing)
                    ) {
                        Text(
                            text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            fontSize = 60.sp,
                            fontWeight = FontWeight.Light,
                            color = Color.Black,
                            maxLines = 2
                        )

                        // "Ac" ,"DEl","/"
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {

                            CalculatorButton(
                                symbol = "AC",
                                modifier = Modifier
                                    .background(LightGray)
                                    .aspectRatio(2f)
                                    .weight(2f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Clear)
                                }
                            )
                            CalculatorButton(
                                symbol = "Del",
                                modifier = Modifier
                                    .background(LightGray)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Delete)
                                }
                            )
                            CalculatorButton(
                                symbol = "/",
                                modifier = Modifier
                                    .background(Orange)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(
                                        CalculatorAction.Operation(
                                            CalculatorOperation.Divide
                                        )
                                    )
                                }
                            )
                        }

                        // "7" ,"8","9","x"
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {

                            CalculatorButton(
                                symbol = "7",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Number(7))
                                }
                            )

                            CalculatorButton(
                                symbol = "8",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Number(8))
                                }
                            )

                            CalculatorButton(
                                symbol = "9",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Number(9))
                                }
                            )
                            CalculatorButton(
                                symbol = "x",
                                modifier = Modifier
                                    .background(Orange)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(
                                        CalculatorAction.Operation(
                                            CalculatorOperation.Multiply
                                        )
                                    )
                                }
                            )
                        }

                        // "4" ,"5","6","-"
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {

                            CalculatorButton(
                                symbol = "4",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Number(4))
                                }
                            )

                            CalculatorButton(
                                symbol = "5",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Number(5))
                                }
                            )

                            CalculatorButton(
                                symbol = "6",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Number(6))
                                }
                            )
                            CalculatorButton(
                                symbol = "-",
                                modifier = Modifier
                                    .background(Orange)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(
                                        CalculatorAction.Operation(
                                            CalculatorOperation.Subtract
                                        )
                                    )
                                }
                            )
                        }

                        // "1" ,"2","3","+"
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {

                            CalculatorButton(
                                symbol = "1",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Number(1))
                                }
                            )

                            CalculatorButton(
                                symbol = "2",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Number(2))
                                }
                            )

                            CalculatorButton(
                                symbol = "3",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Number(3))
                                }
                            )
                            CalculatorButton(
                                symbol = "+",
                                modifier = Modifier
                                    .background(Orange)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(
                                        CalculatorAction.Operation(
                                            CalculatorOperation.Add
                                        )
                                    )
                                }
                            )
                        }

                        // "0" ,".","="
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {

                            CalculatorButton(
                                symbol = "0",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(2f)
                                    .weight(2f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Number(0))
                                }
                            )
                            CalculatorButton(
                                symbol = ".",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Decimal)
                                }
                            )
                            CalculatorButton(
                                symbol = "=",
                                modifier = Modifier
                                    .background(Orange)
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    viewModel.onAction(CalculatorAction.Calculate)
                                }
                            )
                        }

                    }
                }
            }
        }
    }
}

