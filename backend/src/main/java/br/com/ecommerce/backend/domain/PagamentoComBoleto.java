package br.com.ecommerce.backend.domain;

import br.com.ecommerce.backend.domain.enums.EstadoPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PagamentoComBoleto extends Pagamento {

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido,
                              Date dataVencimento, Date dataPagamento) {
        super(id, estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

}
