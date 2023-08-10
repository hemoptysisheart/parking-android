package com.github.hemoptysisheart.parking.app.support

import androidx.compose.foundation.text.KeyboardOptions
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
