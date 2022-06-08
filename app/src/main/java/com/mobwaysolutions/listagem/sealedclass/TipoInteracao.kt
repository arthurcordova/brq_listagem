package com.mobwaysolutions.listagem.sealedclass

sealed class TipoInteracao {

    object OnClickItem : TipoInteracao()
    object OnClickEdit : TipoInteracao()
    object OnClickNew : TipoInteracao()

}
