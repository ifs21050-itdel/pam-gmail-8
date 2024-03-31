package com.ifs21050.pamtantangan8

import java.io.Serializable

class Email(
    val subject: String,
    val sender: String,
    val content: String
) : Serializable {
}
