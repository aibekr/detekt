package io.gitlab.arturbosch.detekt.cli.console

import io.gitlab.arturbosch.detekt.api.ConsoleReport
import io.gitlab.arturbosch.detekt.api.Detektion

class ComplexityReport : ConsoleReport() {

    override val priority: Int = 20

    override fun render(detektion: Detektion): String? {
        val complexityReportGenerator = ComplexityReportGenerator.create(detektion)
        return complexityReportGenerator.generate()?.let { list ->
            with(StringBuilder()) {
                append("Complexity Report:\n")
                list.forEach {
                    append("\t- ")
                    append(it)
                    append("\n")
                }
                toString()
            }
        }
    }
}
