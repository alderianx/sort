	function mask(o, f) {
		setTimeout(function() {
			var v = mphone(o.value);
			if (v != o.value) {
				o.value = v;
			}
		}, 1);
	}

	function mphone(v) {
		var r = v.replace(/\D/g, "");
		r = r.replace(/^0/, "");
		if (r.length > 10) {
			// 11+ digits. Format as 5+4.
			r = r.replace(/^(\d\d)(\d{5})(\d{4}).*/, "($1) $2-$3");
		} else if (r.length > 5) {
			// 6..10 digits. Format as 4+4
			r = r.replace(/^(\d\d)(\d{4})(\d{0,4}).*/, "($1) $2-$3");
		} else if (r.length > 2) {
			// 3..5 digits. Add (0XX..)
			r = r.replace(/^(\d\d)(\d{0,5})/, "($1) $2");
		} else {
			// 0..2 digits. Just add (0XX
			r = r.replace(/^(\d*)/, "($1");
		}
		return r;
	}
	
	function funcao() {
		var data = new Date()

		var dia = ("0" + data.getDate()).slice(-2);
		var mes = ("0" + (data.getMonth() + 1))
				.slice(-2);
		var ano = data.getFullYear();

		var hora = ("0" + data.getHours()).slice(-2);
		var minuto = ("0" + data.getMinutes())
				.slice(-2);
		var segundo = ("0" + data.getSeconds())
				.slice(-2);
		data = hora + ':' + minuto + ':' + segundo
				+ ' ' + ' ' + dia + '/' + mes + '/'
				+ ano;
		// "${#calendars.format(#calendars.createNow(), 'HH:mm:ss  dd/MM/yyyy')}"
		document.getElementById("cadTime").innerHTML = data;
		document.getElementById("inicioTeste").value = data;

	}