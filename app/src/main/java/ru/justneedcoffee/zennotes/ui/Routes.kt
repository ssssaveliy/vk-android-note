package ru.justneedcoffee.zennotes.ui

sealed class Routes(val route: String) {
    object Start : Routes("start")
    object ContinueWithoutAccount : Routes("continueWithoutAccount")
    object Registration : Routes("registration")
    object Login : Routes("login")
    object ForgotPasswordEmail : Routes("forgotPasswordEmail")
    object ConfirmEmail : Routes("confirmEmail")
    object NewPassword : Routes("newPassword")
    object Notes : Routes("notes")
    object NoteEditing : Routes("noteEditing")
    object Error : Routes("error")
}