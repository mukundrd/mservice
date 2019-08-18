package com.trayis.mservice.beans

import com.fasterxml.jackson.annotation.JsonIgnore

class SomeBean(@JsonIgnore val v1: String, val v2: String, val v3: String) {

}
