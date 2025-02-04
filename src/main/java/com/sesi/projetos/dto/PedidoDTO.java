package com.sesi.projetos.dto;

import java.time.Instant;

import ch.qos.logback.core.status.Status;

public record PedidoDTO(Instant momento, Status StatusDoPedido) {

}
