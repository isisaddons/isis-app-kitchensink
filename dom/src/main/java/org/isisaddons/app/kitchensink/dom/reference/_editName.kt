package org.isisaddons.app.kitchensink.dom.reference

import org.apache.isis.applib.annotation.*
import javax.annotation.Nullable

@Mixin(method = "act")
class _editName(private val mixee: ReferenceObject) {

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    @ActionLayout(contributed = Contributed.AS_ACTION)
    fun act(
            @Nullable @ParameterLayout(named = "First name") firstName: String?,
            @ParameterLayout(named = "Last name") lastName: String): ReferenceObject {
        mixee.name = "$firstName $lastName"
        return mixee
    }

    fun default0Act(): String = mixee.name.split(0)

    fun default1Act(): String = mixee.name.split(1)

    private fun String.split(i: Int): String {
        val regex = "\\s".toRegex()
        val parts = split(regex).dropLastWhile ({ it.isEmpty() }) .toTypedArray()
        return if (parts.size > i) parts[i] else ""
    }
}
