package br.com.impacta.calculadoraviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import br.com.impacta.calculadoraviewmodel.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // Pegamos uma instância do nosso ViewModel
    // Quem está gerando essa instância é o compilador
    private val viewModel: CalculadoraViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Criamos os observadores que irão observar o valor das variavéis do nosso ViewModel
        // Eles serão notificados toda vez que o conteúdo das variavéis for alterado.
        viewModel.linhaInferior.observe(viewLifecycleOwner) { linha ->
            // Aqui precisamos indicar como as alterações do conteúdo vai refletir no layout
            binding.textLinhaInferior.text = linha
        }
        viewModel.linhaSuperior.observe(viewLifecycleOwner) { linha ->
            binding.textLinhaSuperior.text = linha
        }

        // Aqui ao invés de implementarmos os códigos de ações dos botões
        // esses códigos de implementação vão para o ViewModel ou para a camada de dados
        // e fazemos uso dos métodos do ViewModel
        // A atividade/fragmento só "notifica" o ViewModel de que houve interação com o usuário
        binding.btnNum0.setOnClickListener { viewModel.digitaNumero((it as Button).text.toString()) }
        binding.btnNum1.setOnClickListener { viewModel.digitaNumero((it as Button).text.toString()) }
        binding.btnNum2.setOnClickListener { viewModel.digitaNumero((it as Button).text.toString()) }
        binding.btnNum3.setOnClickListener { viewModel.digitaNumero((it as Button).text.toString()) }
        binding.btnNum4.setOnClickListener { viewModel.digitaNumero((it as Button).text.toString()) }
        binding.btnNum5.setOnClickListener { viewModel.digitaNumero((it as Button).text.toString()) }
        binding.btnNum6.setOnClickListener { viewModel.digitaNumero((it as Button).text.toString()) }
        binding.btnNum7.setOnClickListener { viewModel.digitaNumero((it as Button).text.toString()) }
        binding.btnNum8.setOnClickListener { viewModel.digitaNumero((it as Button).text.toString()) }
        binding.btnNum9.setOnClickListener { viewModel.digitaNumero((it as Button).text.toString()) }
        binding.btnNumPonto.setOnClickListener { viewModel.digitaNumero((it as Button).text.toString()) }
        binding.btnNumApagar.setOnClickListener { viewModel.digitaNumero("-1") }

        binding.btnOprAdicao.setOnClickListener { viewModel.digitaOperacao((it as Button).text.toString()) }
        binding.btnOprSubtracao.setOnClickListener { viewModel.digitaOperacao((it as Button).text.toString()) }
        binding.btnOprMultiplicacao.setOnClickListener { viewModel.digitaOperacao((it as Button).text.toString()) }
        binding.btnOprDivisao.setOnClickListener { viewModel.digitaOperacao((it as Button).text.toString()) }
        binding.btnOprPorcetagem.setOnClickListener { viewModel.digitaOperacao((it as Button).text.toString()) }

        binding.btnOprIgual.setOnClickListener { viewModel.mostraResultado() }


    }


}