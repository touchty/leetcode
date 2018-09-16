class NumberOfAtoms {
public:
	string countOfAtoms(string formula) {
		stack<map<string, int>> state;
		state.push({});

		int i = 0;
		while (i < formula.length()) {
			if (formula[i] == '(') {
				state.push({});
				++i;
			}
			else if (formula[i] == ')') {
				++i;
				int d = 0;
				while (i < formula.length() && isdigit(formula[i])) {
					d = d * 10 + (int)(formula[i] - '0');
					++i;
				}
				if (d == 0) d = 1;

				map<string, int> current = state.top();
				state.pop();
				for (auto& p : current) {
					p.second *= d;
					if (state.top().find(p.first) == state.top().end())
					{
						state.top().insert(p);
					}
					else
					{
						state.top()[p.first] += p.second;
					}
				}
			}
			else if (isupper(formula[i])) {
				int pos = i++;
				while (i < formula.length() && islower(formula[i])) ++i;
				string name = formula.substr(pos, i - pos);

				int d = 0;
				while (i < formula.length() && isdigit(formula[i])) {
					d = d * 10 + (int)(formula[i] - '0');
					++i;
				}
				if (d == 0) d = 1;

				map<string, int>& current = state.top();
				if (current.find(name) == current.end()) {
					current.insert(make_pair(name, d));
				}
				else {
					current[name] += d;
				}
			}
		}

		string res = "";
		for (auto& p : state.top()) {
			res += p.first;
			if (p.second > 1)
			{
				res += to_string(p.second);
			}

		}

		return res;
	}
};