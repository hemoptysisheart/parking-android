package com.github.hemoptysisheart.parking.app.ui.support

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

/**
 * @see KeyboardType.Ascii
 */
val KEYBOARD_ASCII = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Ascii)

/**
 * @see KeyboardType.Number
 */
val KEYBOARD_NUMBER = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)

/**
 * @see KeyboardType.Phone
 */
val KEYBOARD_PHONE = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone)

/**
 * @see KeyboardType.Uri
 */
val KEYBOARD_URI = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Uri)

/**
 * @see KeyboardType.Email
 */
val KEYBOARD_EMAIL = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)

/**
 * @see KeyboardType.Password
 */
val KEYBOARD_PASSWORD = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)

/**
 * @see KeyboardType.NumberPassword
 */
val KEYBOARD_NUMBER_PASSWORD = KeyboardOptions.Default.copy(keyboardType = KeyboardType.NumberPassword)

/**
 * @see KeyboardType.Decimal
 */
val KEYBOARD_DECIMAL = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Decimal)

/**
 * @see ImeAction.Go
 */
val KEYBOARD_URL = KeyboardOptions.Default.copy(imeAction = ImeAction.Go)

/**
 * @see ImeAction.Search
 */
val KEYBOARD_SEARCH = KeyboardOptions.Default.copy(imeAction = ImeAction.Search)

/**
 * @see ImeAction.Send
 */
val KEYBOARD_SEND = KeyboardOptions.Default.copy(imeAction = ImeAction.Send)

/**
 * @see ImeAction.Previous
 */
val KEYBOARD_PREVIOUS = KeyboardOptions.Default.copy(imeAction = ImeAction.Previous)

/**
 * @see ImeAction.Next
 */
val KEYBOARD_NEXT = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)

/**
 * @see ImeAction.Done
 */
val KEYBOARD_DONE = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
