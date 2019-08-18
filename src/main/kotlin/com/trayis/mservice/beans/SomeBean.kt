package com.trayis.mservice.beans

import com.fasterxml.jackson.annotation.JsonFilter
import com.fasterxml.jackson.annotation.JsonIgnore

@JsonFilter("SomeBeanFilter")
class SomeBean(@JsonIgnore val v1: String, val v2: String, val v3: String)
