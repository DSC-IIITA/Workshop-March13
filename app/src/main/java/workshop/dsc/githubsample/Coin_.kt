package workshop.dsc.githubsample

import java.util.HashMap
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("btc", "name", "rank", "ticker", "usd")
class Coin_ {

    @JsonProperty("btc")
    @get:JsonProperty("btc")
    @set:JsonProperty("btc")
    var btc: Int? = null
    @JsonProperty("name")
    @get:JsonProperty("name")
    @set:JsonProperty("name")
    var name: String? = null
    @JsonProperty("rank")
    @get:JsonProperty("rank")
    @set:JsonProperty("rank")
    var rank: Int? = null
    @JsonProperty("ticker")
    @get:JsonProperty("ticker")
    @set:JsonProperty("ticker")
    var ticker: String? = null
    @JsonProperty("usd")
    @get:JsonProperty("usd")
    @set:JsonProperty("usd")
    var usd: Double? = null
    @JsonIgnore
    private val additionalProperties = HashMap<String, Any>()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any> {
        return this.additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        this.additionalProperties[name] = value
    }

}
