package ru.catstack.lynlissaart.data.api.deviantart

import okhttp3.ResponseBody
import org.w3c.dom.Element
import retrofit2.Converter
import retrofit2.Retrofit
import ru.catstack.lynlissaart.domain.Art
import ru.catstack.lynlissaart.domain.DeviantResponse
import java.lang.reflect.Type
import javax.xml.parsers.DocumentBuilderFactory

class DeviantResponseConverterFactory : Converter.Factory() {
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, DeviantResponse>? {
        return if (type == DeviantResponse::class.java) DeviantResponseConverter else null
    }

    private object DeviantResponseConverter : Converter<ResponseBody, DeviantResponse> {
        override fun convert(value: ResponseBody): DeviantResponse? {
            val text = value.string()
            val response = DeviantResponse(ArrayList())
            val builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()

            val doc = builder.parse(text.byteInputStream())
            val items = doc.getElementsByTagName("item")

            for (i in 0 until items.length) {
                val item = items.item(i) as Element

                val titleElement = item.getElementsByTagName("title").item(0) as Element
                val title = titleElement.textContent

                val urlElement = item.getElementsByTagName("media:content").item(0) as Element
                val url = urlElement.getAttribute("url")

                response.arts.add(Art(title, url))
            }

            return response
        }

    }
}