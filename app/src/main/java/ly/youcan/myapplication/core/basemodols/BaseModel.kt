package ly.youcan.myapplication.core.basemodols

abstract class BaseModel <M,E>{
    abstract fun converToEntity():E
}